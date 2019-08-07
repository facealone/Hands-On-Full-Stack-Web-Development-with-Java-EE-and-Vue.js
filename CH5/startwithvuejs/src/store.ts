import Vue from 'vue'
import Vuex from 'vuex'
import { FoodProduct } from './entities/FoodProduct'
import { FoodService } from './entities/FoodService'
import { State } from './entities/State'

Vue.use(Vuex)

const stateBase: State = {
  foodProducts: [
    FoodProduct.newFoodProduct(1, 'Daniel Pelaez', 'danielpelaez@email.com', 1.2, 'image', 'email1@email.com'),
    FoodProduct.newFoodProduct(2, 'Hector Hurtado', 'hectorhurtado@email.com', 1.2, 'image', 'email1@email.com'),
    FoodProduct.newFoodProduct(3, 'William Agreda', 'williamagreda@email.com', 1.2, 'image', 'email1@email.com'),
    FoodProduct.newFoodProduct(4, 'Roger Salazar', 'rogersalazar@email.com', 1.2, 'image', 'email2@email.com')
  ],
  foodServices: [
    FoodService.newFoodService('email1@email.com', 'Service1', 'Street1', 'PIZZA', 1.2, 'image', 'pass'),
    FoodService.newFoodService('email2@email.com', 'Service2', 'Street2', 'PIZZA', 1.2, 'image', 'pass'),
    FoodService.newFoodService('email3@email.com', 'Service3', 'Street3', 'CHINESE', 1.2, 'image', 'pass'),
    FoodService.newFoodService('email4@email.com', 'Service4', 'Street4', 'CHINESE', 1.2, 'image', 'pass')
  ],
  currentFoodServiceLoggedIn: '',
  currentDeliveryEmail: ''
}

export default new Vuex.Store<State>({
  state: stateBase,
  mutations: {
    saveFoodProduct (state:State, foodProduct:FoodProduct) {
      foodProduct.id = state.foodProducts.length + 1
      state.foodProducts.push(foodProduct)
    },
    removeFoodProduct (state:State, foodProductToRemove:FoodProduct) {
      const index = state.foodProducts.findIndex(foodProduct => foodProduct.id === foodProductToRemove.id)

      Vue.delete(state.foodProducts, index)
    },
    updateFoodProduct (state:State, foodProductToUpdate:FoodProduct) {
      let foodProduct:FoodProduct | undefined = state.foodProducts.find(foodProduct => foodProduct.id === foodProductToUpdate.id)

      foodProduct!.copyFoodProduct(foodProductToUpdate)
    },
    saveFoodService (state:State, foodService:FoodService) {
      state.foodServices.push(foodService)
    },
    removeFoodService (state:State, foodServiceToRemove:FoodService) {
      const index = state.foodServices.findIndex(foodService => foodService.email === foodServiceToRemove.email)

      Vue.delete(state.foodServices, index)
    },
    updateFoodService (state:State, foodServiceToUpdate:FoodService) {
      let foodService:FoodService | undefined = state.foodServices.find(foodService => foodService.email === foodServiceToUpdate.email)

      foodService!.copyFoodService(foodServiceToUpdate)
    },
    setCurrentFoodServiceLoggedIn (state:State, foodService:string) {
      state.currentFoodServiceLoggedIn = foodService
    },
    setCurrentDeliveryEmail (state:State, currentDeliveryEmail:string) {
      state.currentDeliveryEmail = currentDeliveryEmail
    }
  },
  actions: {

  },
  getters: {
    getFoodProductById: (state) => (id:number) => {
      return state.foodProducts.find(foodProduct => foodProduct.id === id)
    },
    getFoodProductByFoodService: (state) => (foodService:string) => {
      return state.foodProducts.filter(foodProduct => foodProduct.foodService === foodService)
    },
    getFoodServiceByEmail: (state) => (email:string) => {
      return state.foodServices.find(foodService => foodService.email === email)
    },
    getFoodServiceByFoodType: (state) => (foodType:string) => {
      return state.foodServices.filter(foodService => foodType === 'ALL' || foodService.foodType === foodType)
    },
    getFoodServiceByEmailAndPassword: (state) => (email:string, password:string) => {
      return state.foodServices.find(foodService => foodService.email === email && foodService.password === password)
    },
    getCurrentFoodServiceLoggedIn: (state) => () => {
      return state.currentFoodServiceLoggedIn
    }
  }
})
