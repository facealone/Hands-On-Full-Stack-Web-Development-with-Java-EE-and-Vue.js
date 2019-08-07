<template>
  <div>
    <div class="row">
      <div class="col-sm">
        <div class="form-group">
          <label for="name">Name</label>
          <input
            v-model="foodServiceData.name"
            type="text"
            class="form-control"
            id="name"
            placeholder="Name"
            disabled
          />
        </div>
      </div>
      <div class="col-sm">
          <div class="form-group">
            <label for="deliveryFee">Fee for Delivery</label>
            <input
              v-model="foodServiceData.deliveryFee"
              type="text"
              class="form-control"
              id="deliveryFee"
              placeholder="deliveryFee"
              disabled
            />
          </div>
        </div>
    </div>
    <h2 class="text-center">Food Products</h2>
    <div class="row mt-2">
      <div class="col-sm">
        <table class="table  table-dark">
          <thead>
            <tr>
              <th></th>
              <th>Id</th>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in items" v-bind:key="item.foodProduct.id">
              <td>{{item.foodProduct.image}}</td>
              <td>{{item.foodProduct.id}}</td>
              <td>{{item.foodProduct.name}}</td>
              <td>{{item.foodProduct.description}}</td>
              <td>{{item.foodProduct.price}}</td>
              <td>
                 <div class="input-group mb-3">
                      <input
                          v-model="item.amount"
                          type="number"
                          class="form-control"
                          id="amount"
                          placeholder="amount"
                        >
                    <div class="input-group-append">
                      <a v-on:click="addToCart(item)" class="btn btn-outline-primary">Add</a>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
    </div>
    </div>
  </div>
</template>

<script lang="ts">
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { Component, Vue, Prop } from 'vue-property-decorator'
import { FoodProduct } from '../../entities/FoodProduct'
import { FoodService } from '../../entities/FoodService'
import { Item } from '../../entities/Item'

@Component
export default class FoodProductsByService extends Vue {
  @Prop() private readonly foodService!: string
  items:Item[] = []
  foodServiceData: FoodService = FoodService.emptyFoodService()

  // lifecycle hook
  mounted () {
    this.getFoodProducts(this.foodService)
  }

  getFoodProducts (foodService: string) {
    this.items = this.$store.getters.getFoodProductByFoodService(foodService).map((foodProduct: FoodProduct) => Item.newItem(foodProduct, 0))
    this.foodServiceData = this.$store.getters.getFoodServiceByEmail(
      foodService
    )
  }

  addToCart (item: Item) {
    this.$store.commit('saveItemToCart', item)

    this.$router.push({ name: 'cart', params: { foodService: this.foodService } })
  }
}
</script>
