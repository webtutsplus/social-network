import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import UserList from '../views/ListUsers.vue'
import Chat from '../components/Chat.vue'
import Room from '../components/Room.vue'
import AddRoom from '../components/AddRoom.vue'
import ListFriends from "../views/ListFriends";
import wChat from "@/components/wChat";

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
    path: '/listfriends',
    name: 'ListFriends',
    component: ListFriends
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
  },
  {
    path: '/friends',
    name: 'Friends',
    component: ListFriends
  },{
    path: '/wchat',
    name: 'wchat',
    component: wChat
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
