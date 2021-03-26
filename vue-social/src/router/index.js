import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import UserList from '../views/ListUsers.vue'
import Chat from '../components/Chat.vue'
import Room from '../components/Room.vue'
import AddRoom from '../components/AddRoom.vue'
import Posts from "../views/Posts";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },{
    path: '/listusers',
    name: 'ListUsers',
    component: UserList
  },{
    path: '/posts',
    name: 'Posts',
    component: Posts
  },
  {
    path: '/chat/:nickname/:roomid/:roomname',
    name: 'Chat',
    component: Chat
  },
  {
    path: '/room/:nickname',
    name: 'RoomList',
    component: Room
  },
  {
    path: '/add-room',
    name: 'AddRoom',
    component: AddRoom
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
