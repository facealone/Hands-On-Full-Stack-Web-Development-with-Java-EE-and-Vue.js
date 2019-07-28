import Vue from 'vue'
import Vuex from 'vuex'
import { FoodProduct } from './entities/FoodProduct'
import { State } from './entities/State'

Vue.use(Vuex)

const stateBase: State = {
  foodProducts: [
    FoodProduct.newFoodProduct(1, 'Daniel Pelaez', 'danielpelaez@email.com', 1.2, 'image'),
    FoodProduct.newFoodProduct(2, 'Hector Hurtado', 'hectorhurtado@email.com', 1.2, 'image'),
    FoodProduct.newFoodProduct(3, 'William Agreda', 'williamagreda@email.com', 1.2, 'image'),
    FoodProduct.newFoodProduct(4, 'Roger Salazar', 'rogersalazar@email.com', 1.2, 'image')
  ]
}

export default new Vuex.Store<State>({
  state: stateBase,
  mutations: {
    saveFoodProduct (state:State, foodProduct:FoodProduct) {
      state.foodProducts.push(foodProduct)
    },
    removeFoodProduct (state:State, foodProductToRemove:FoodProduct) {
      const index = state.foodProducts.findIndex(foodProduct => foodProduct.id === foodProductToRemove.id)

      Vue.delete(state.foodProducts, index)
    },
    updateFoodProduct (state:State, foodProductToUpdate:FoodProduct) {
      let foodProduct:FoodProduct | undefined = state.foodProducts.find(foodProduct => foodProduct.id === foodProductToUpdate.id)

      foodProduct!.copyFoodProduct(foodProductToUpdate)
    }
  },
  actions: {

  },
  getters: {
    getFoodProductById: (state) => (id:number) => {
      return state.foodProducts.find(foodProduct => foodProduct.id === id)
    }
  }
})
