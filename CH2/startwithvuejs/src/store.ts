import Vue from 'vue'
import Vuex from 'vuex'
import { User } from './entities/User'
import { State } from './entities/State'

Vue.use(Vuex)

const stateBase: State = {
  users: [
    new User('danielp', 'password123', 'admin'),
    new User('hectorh', 'password123', 'user'),
    new User('williama', 'password123', 'user'),
    new User('rogerss', 'password123', 'user')
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
      const index = state.users.findIndex(user => user.username === userToRemove.username)

      delete state.users[index]
    }
  },
  actions: {

  }
})
