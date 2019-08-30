import axios from 'axios'
import { FoodService } from '../entities/FoodService'
import { User } from '../entities/User'

export class FoodServiceService {
  static create (foodService: FoodService) {
    return axios.post<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices`, foodService)
  }

  static login (user: User) {
    return axios.post<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices/login`, user)
  }
}
