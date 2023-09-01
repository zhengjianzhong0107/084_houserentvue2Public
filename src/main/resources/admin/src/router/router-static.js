import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import fangwuleixing from '@/views/modules/fangwuleixing/list'
    import discussfangyuanchushou from '@/views/modules/discussfangyuanchushou/list'
    import fangyuanchuzu from '@/views/modules/fangyuanchuzu/list'
    import fangyuangoumai from '@/views/modules/fangyuangoumai/list'
    import jingjiren from '@/views/modules/jingjiren/list'
    import fangyuanchushou from '@/views/modules/fangyuanchushou/list'
    import fangyuanleixing from '@/views/modules/fangyuanleixing/list'
    import discussfangyuanchuzu from '@/views/modules/discussfangyuanchuzu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chushoukanfang from '@/views/modules/chushoukanfang/list'
    import kanfangyuyue from '@/views/modules/kanfangyuyue/list'
    import config from '@/views/modules/config/list'
    import zufangxinxi from '@/views/modules/zufangxinxi/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/fangwuleixing',
        name: '房屋类型',
        component: fangwuleixing
      }
      ,{
	path: '/discussfangyuanchushou',
        name: '房源出售评论',
        component: discussfangyuanchushou
      }
      ,{
	path: '/fangyuanchuzu',
        name: '房源出租',
        component: fangyuanchuzu
      }
      ,{
	path: '/fangyuangoumai',
        name: '房源购买',
        component: fangyuangoumai
      }
      ,{
	path: '/jingjiren',
        name: '经纪人',
        component: jingjiren
      }
      ,{
	path: '/fangyuanchushou',
        name: '房源出售',
        component: fangyuanchushou
      }
      ,{
	path: '/fangyuanleixing',
        name: '房源类型',
        component: fangyuanleixing
      }
      ,{
	path: '/discussfangyuanchuzu',
        name: '房源出租评论',
        component: discussfangyuanchuzu
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/chushoukanfang',
        name: '出售看房',
        component: chushoukanfang
      }
      ,{
	path: '/kanfangyuyue',
        name: '看房预约',
        component: kanfangyuyue
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/zufangxinxi',
        name: '租房信息',
        component: zufangxinxi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
