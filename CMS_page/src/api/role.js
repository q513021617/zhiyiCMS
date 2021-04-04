import { setCookie } from '@/tools/cookie'
import httpmethods from '@/tools/http'

let addRole = function (data) {
  let { enname, name, url } = data
  let Roledata = new FormData()
  Roledata.append('enname', enname)
  Roledata.append('name', name)
  return httpmethods.axios.post(
    '/api/admin/role/', Roledata)
}

let delRole = function (id) {
  let userdata = new FormData()
  userdata.append('id', id)
  return httpmethods.axios.post('/api/admin/role/del/', userdata)
}

let getRole = function (id) {
  return httpmethods.axios
    .get('/api/admin/role/' + id, {})
}
let getRoleBypPage = function () {
  return httpmethods.axios
    .get('/api/admin/role/0/20', {})
}
let updateRole = function (data) {
  let { enname, name, id, url } = data
  let Roledata = new FormData()
  Roledata.append('id', id)
  Roledata.append('enname', enname)
  Roledata.append('name', name)
  return httpmethods.axios.post(
    '/api/admin/role/', Roledata)
}
export {
  addRole, delRole, updateRole, getRole, getRoleBypPage
}