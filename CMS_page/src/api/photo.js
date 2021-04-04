import httpmethods from '@/tools/http'

let updatePhoto = function (photo) {
  let { id, photoName, srcUrl } = photo
  let photodata = new FormData()
  photodata.append('id', id)
  photodata.append('photoName', photoName)
  photodata.append('srcUrl', srcUrl)

  return httpmethods.axios.post('/api/admin/photo/', photodata)
}

let delPhoto = function (id) {

  let photodata = new FormData()
  photodata.append('id', id)
  return httpmethods.axios.post('/api/admin/photo/delete', photodata)
}

let addPhoto = function (photo) {
  let { id, photoName, srcUrl } = photo
  let photodata = new FormData()
  photodata.append('photoName', photoName)
  photodata.append('srcUrl', srcUrl)
  return httpmethods.axios.post('/api/admin/photo/', photodata)
}
let uploadfile = function (file) {
  let photodata = new FormData()
  photodata.append('photo', file)
  return httpmethods.axios.post('/api/api/file/upload/', photodata)
}
let getPhoto = function (banner) {

}
export {
  updatePhoto, delPhoto, addPhoto, getPhoto, uploadfile
}