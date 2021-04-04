import { setCookie } from '@/tools/cookie'
import httpmethods from '@/tools/http'

let addMenu = function (data) {
  let { enname, name, url } = data
  let menudata = new FormData()
  menudata.append('enname', enname)
  menudata.append('name', name)
  menudata.append('url', url)
  return httpmethods.axios.post(
    '/api/admin/permission/', menudata)
}

let delMenu = function (id) {
  let userdata = new FormData()
  userdata.append('id', id)
  return httpmethods.axios.post('/api/admin/permission/del/', userdata)
}

let getMenu = function (id) {
  return httpmethods.axios
    .get('/api/admin/permission/' + id, {})
}

let updateMenu = function (data) {
  let { enname, name, id, url } = data
  let menudata = new FormData()
  menudata.append('id', id)
  menudata.append('enname', enname)
  menudata.append('name', name)
  menudata.append('url', url)
  return httpmethods.axios.post(
    '/api/admin/permission/', menudata)
}
export {
  addMenu, delMenu, updateMenu, getMenu
}