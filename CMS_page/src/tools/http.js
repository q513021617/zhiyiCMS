import axios from 'axios'
import Vue from 'vue'
// Vue.use(axios);


axios.defaults.timeout=3000;
// axios.defaults.baseURL = 'http://localhost:8888';

const pending = {};
const CancelToken = axios.CancelToken;
const removePending = (key, isRequest = false) => {
            if (pending[key] && isRequest) {
                pending[key]('取消重复请求')
            }
            delete pending[key]
        };
const getRequestIdentify = (config, isReuest = false) => {
            console.log( config.url );
            let url = config.url;
            if (isReuest) {
                url = config.baseURL + config.url.substring(1, config.url.length)
            }
  return config.method === 'get' ? encodeURIComponent(url + JSON.stringify(config.params)) : encodeURIComponent(config.url + JSON.stringify(config.data))
        };

        // 请求拦截器
        axios.interceptors.request.use(config => {
            // 拦截重复请求(即当前正在进行的相同请求)
            let requestData = getRequestIdentify(config, true);
            removePending(requestData, true);
            // 为请求头添加token 验证的 Authorization 字段
            // config.headers.Authorization = window.sessionStorage.getItem('token')
            config.cancelToken = new CancelToken((c) => {
                pending[requestData] = c
            });
            return config
        }, error => {
            return Promise.reject(error);
        });

// 请求数据方法封装

  var  delDataFuc = function delData(data,url,callback) {


            axios.delete(url,{params:data})
                .then(function (result) {
                            console.log("删除: "+result);
                            
                  
                            callback();
                    console.log(result);

                })
                .catch(function (error) {
                    console.log(error);
                });


        }

        var updateDataFuc =   function updateData(data,url,callback) {


            axios.put(url,data)
                .then(function (result) {
                            console.log("更新: "+result);

                    
                            callback();

                })
                .catch(function (error) {
                    console.log(error);
                });

        }
        var addDataFuc =  function addData(data,url,callback) {


            axios.post(url,data)
                .then(function (result) {
                    console.log("添加: "+result);

              
                    callback();

                })
                .catch(function (error) {
                    console.log(error);
                });

        }
        var getDataFuc = function getData(data,url,callback) {


            axios.get(url,{params:data})
                .then(function (result) {
                    console.log("获取: "+result);
               
                    callback();

                })
                .catch(function (error) {
                    console.log(error);
                });

        }
        
        const httpmethods = {
            axios,
             delDataFuc,
             updateDataFuc,
             addDataFuc,
             getDataFuc
        }

export default httpmethods

