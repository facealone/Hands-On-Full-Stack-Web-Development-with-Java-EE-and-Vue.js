import Vue from 'vue'
import Vuex from 'vuex'
import { FoodService } from './entities/FoodService'
import { Item } from './entities/Item'
import { State } from './entities/State'
import { Cart } from './entities/Cart'
import { Token } from './entities/Token'

Vue.use(Vuex)

const stateBase: State = {
  cart: Cart.emptyCart(),
  currentDeliveryEmail: '',
  token: Token.emptyToken()
}

export default new Vuex.Store<State>({
  state: stateBase,
  mutations: {
    setCurrentDeliveryEmail (state:State, currentDeliveryEmail:string) {
      state.currentDeliveryEmail = currentDeliveryEmail
    },
    saveItemToCart (state:State, item:Item) {
      state.cart.items.push(item)
    },
    removeItemFromCart (state:State, itemToRemove:Item) {
      const index = state.cart.items.findIndex(item => item.foodProduct.id === itemToRemove.foodProduct.id)

      Vue.delete(state.cart.items, index)
    },
    setToken (state:State, token:Token) {
      state.token = token
    }
  },
  actions: {

  },
  getters: {
    getCurrentDeliveryEmail: (state) => () => {
      return state.currentDeliveryEmail
    },
    getToken: (state) => () => {
      return state.token
    }
  }
})
