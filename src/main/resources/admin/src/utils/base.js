const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmc051q/",
            name: "ssmc051q",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmc051q/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "安居房地产销售系统"
        } 
    }
}
export default base
