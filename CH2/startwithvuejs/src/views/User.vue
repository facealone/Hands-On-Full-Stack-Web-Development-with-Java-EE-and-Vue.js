<template>
  <div>
    <div class="nav">
      <router-link to="/user/list">List</router-link> |
      <router-link to="/user/create">Create</router-link>
    </div>
    <router-view/>
  </div>
</template>

<style>
.nav {
  padding: 30px;
}

.nav a {
  font-weight: bold;
  color: #2c3e50;
}

.nav a.router-link-exact-active {
  color: #42b983;
}
</style>
