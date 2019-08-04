import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import FoodProduct from './views/FoodProduct.vue'
import FoodProductList from './components/foodProduct/FoodProductList.vue'
import FoodProductNew from './components/foodProduct/FoodProductNew.vue'
import FoodProductUpdate from './components/foodProduct/FoodProductUpdate.vue'
import FoodService from './views/FoodService.vue'
import FoodServiceView from './components/foodService/FoodServiceView.vue'
import FoodServiceNew from './components/foodService/FoodServiceNew.vue'
import FoodServiceUpdate from './components/foodService/FoodServiceUpdate.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/food_product',
      component: FoodProduct,
      children: [
        {
          path: '/',
          name: 'food_product_list',
          component: FoodProductList
        },
        {
          path: 'new',
          name: 'food_product_new',
          component: FoodProductNew
        },
        {
          path: ':id',
          name: 'food_product_update',
          props: (route) => { return { id: route.params.id } },
          component: FoodProductUpdate
        }
      ]
    },
    {
      path: '/food_service',
      component: FoodService,
      children: [
        {
          path: 'update/:email',
          name: 'food_service_update',
          props: (route) => { return { email: route.params.email } },
          component: FoodServiceUpdate
        },
        {
          path: 'new',
          name: 'food_service_new',
          component: FoodServiceNew
        },
        {
          path: ':email',
          name: 'food_service_view',
          props: (route) => { return { email: route.params.email } },
          component: FoodServiceView
        }
      ]
    },
    {
      path: '/about',
      name: 'about',
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})
