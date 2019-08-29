import axios from 'axios';

export class DeliveryService{
    static getDeliveriesByEmailAndState(email:string, state:string){
        return axios.get(`http://localhost:8080/StartWithJEE8-web/api/deliveries/${email}?state=P${state}`)
    }
}
