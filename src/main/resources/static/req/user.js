function queryUserDetail (id){

    return axios.get("/api/user/"+id,{})
}

function delUserById (id){

    return axios.delete("/api/user/"+id,{})
}
function getUserNum(num){

    return axios.get("/getUserNum/"+num,{})
}

function saveUser(data){

    return axios.post("/admin/webUser/",data)
}