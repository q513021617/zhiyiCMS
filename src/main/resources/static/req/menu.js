function queryMenuList (){

    return axios.get("/admin/permission/",{})
}

function queryMenuById(id){

    return axios.get("/admin/permission/"+id,{})
}