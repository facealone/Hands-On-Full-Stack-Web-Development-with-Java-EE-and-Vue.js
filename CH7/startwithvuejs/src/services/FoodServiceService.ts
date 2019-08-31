import axios from 'axios'
import { FoodService } from '../entities/FoodService'
import { User } from '../entities/User'

export class FoodServiceService {
  static getById (email: string) {
    return axios.get<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices/${email}`)
  }

  static create (foodService: FoodService) {
    return axios.post<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices`, foodService)
  }

  static update (foodService: FoodService) {
    return axios.put<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices`, foodService)
  }

  static login (user: User) {
    return axios.post<FoodService>(`http://localhost:8080/StartWithJEE8-web/api/foodservices/login`, user)
  }

  static getByFoodType (foodType:string, page:number, pageSize:number) {
    return axios.get<Array<FoodService>>(`http://localhost:8080/StartWithJEE8-web/api/foodservices?foodType=${foodType}&page=${page}&pageSize=${pageSize}`)
  }
}
