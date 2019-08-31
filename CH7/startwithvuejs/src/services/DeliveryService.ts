import axios from 'axios'
import { Delivery } from '../entities/Delivery'

export class DeliveryService {
  static getDeliveriesByEmailAndState (email:string, state:string) {
    return axios.get<Array<Delivery>>(`http://localhost:8080/StartWithJEE8-web/api/deliveries/${email}?state=${state}`)
  }

  static request (delivery: Delivery) {
    return axios.post<Delivery>(`http://localhost:8080/StartWithJEE8-web/api/deliveries`, delivery)
  }
}
