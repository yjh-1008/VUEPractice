import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/pages/Home'
import Login from '@/pages/Login'
import Cart from '@/pages/Cart'
const routes = [
    {path:'/', component: Home},
    {path:'/login', component: Login},
    {path:'/cart', component: Cart},
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router