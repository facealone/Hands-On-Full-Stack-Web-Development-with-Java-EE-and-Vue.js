import Vue from 'vue'
import Vuex from 'vuex'
import { User } from './entities/User'
import { Role } from './entities/Role'
import { State } from './entities/State'

Vue.use(Vuex)

const stateBase: State = {
  users: [
    new User('Daniel Pelaez', 'danielpelaez@email.com', 'password123', Role.ADMIN),
    new User('Hector Hurtado', 'hectorhurtado@email.com', 'password123', Role.USER),
    new User('William Agreda', 'williamagreda@email.com', 'password123', Role.USER),
    new User('Roger Salazar', 'rogersalazar@email.com', 'password123', Role.USER)
  ]
}
// https://github.com/ktsn/vuex-class
export default new Vuex.Store<State>({
  state: stateBase,
  mutations: {
    saveUser (state:State, user:User) {
      state.users.push(user)
    },
    removeUser (state:State, userToRemove:User) {
      const index = state.users.findIndex(user => user.email === userToRemove.email)

      Vue.delete(state.users, index)
    }
  },
  actions: {

  }
})
