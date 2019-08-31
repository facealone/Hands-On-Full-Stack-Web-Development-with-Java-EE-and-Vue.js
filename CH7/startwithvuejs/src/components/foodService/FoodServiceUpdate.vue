<template>
  <div>
    <FoodServiceForm v-on:foodServiceFilled="update($event)" :foodService="foodService" :type="type"></FoodServiceForm>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import FoodServiceForm from '@/components/foodService/FoodServiceForm.vue'
import { FoodService } from '../../entities/FoodService'
import { FoodServiceService } from '../../services/FoodServiceService'

@Component({
  components: {
    FoodServiceForm
  }
})
export default class FoodServiceUpdate extends Vue {
  @Prop() private readonly email!: string
  private type:string = 'update'

  private foodService:FoodService = FoodService.emptyFoodService()

  mounted () {
    this.getFoodService(this.email)
  }

  getFoodService (email:string) {
    // let foodServiceToUpdate:FoodService = this.$store.getters.getFoodServiceByEmail(email)
    FoodServiceService.getById(email)
      .then(response => {
        console.log(response)

        this.foodService = response.data
      })
      .catch(error => {
        console.log(error)
      })
  }

  update (foodService:FoodService) {
    // this.$store.commit('updateFoodService', foodService)
    FoodServiceService.update(foodService)
      .then(response => {
        console.log(response)

        this.$router.push({ name: 'food_service_view' })
      })
      .catch(error => {
        console.log(error)
      })
  }
}
</script>
