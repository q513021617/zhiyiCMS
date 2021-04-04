import { setCookie } from '@/tools/cookie'
import httpmethods from '@/tools/http'
let login = function (username, password, message) {


  if (username == undefined || password == undefined) {
    this.erro = '用户名或者密码不能为空!'
    return
  }

  console.log(username + ' ' + password)
  var _this = this
  $.post(
    '/api/user/login',
    { username: username, password: password },
    function (data) {
      console.log(data)

      if (data != undefined && data != '') {
        setCookie('userdata', data.id)
        message({ ToastTitle: '提示:', Toasttext: '登录成功' })
        location.href = '/#/index/home'
        return
      }

      if (!(data != undefined && data != '')) {
        message({ ToastTitle: '提示:', Toasttext: '密码或账号错误' })
        return
      }
    }
  )
}

let updateUser = function (data) {
  let { username, password, id, sex, email, role, phone } = data
  let userdata = new FormData()
  userdata.append('id', id)
  userdata.append('username', username)
  userdata.append('password', password)
  userdata.append('sex', sex)
  userdata.append('email', email)
  userdata.append('role', role)
  userdata.append('phone', phone)
  console.log(userdata)
  return httpmethods.axios.post(
    '/api/admin/webUser/', userdata)

}

let addUser = function (data) {
  let { username, password, sex, email, role, phone } = data
  let userdata = new FormData()
  userdata.append('username', username)
  userdata.append('password', password)
  userdata.append('sex', sex)
  userdata.append('email', email)
  userdata.append('phone', phone)
  userdata.append('role', role)

  return httpmethods.axios.post(
    '/api/admin/webUser/', userdata)


}

let delUser = function (id) {
  let userdata = new FormData()
  userdata.append('id', id)
  return httpmethods.axios.post('/api/admin/webUser/del/', userdata)

}

let getUser = function (id) {
  return httpmethods.axios
    .get('/api/admin/webUser/' + id, {})
}
let queryAllUserBypage = function (page, size) {

  return httpmethods.axios
    .get('/api/admin/webUser/' + page + '/' + size, {})
}
export {
  login, updateUser, delUser, getUser, addUser, queryAllUserBypage
}