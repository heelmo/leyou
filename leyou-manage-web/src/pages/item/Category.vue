<template>
  <v-card>
      <v-flex xs12 sm10>
        <v-tree url="/item/category/list"
                :isEdit="isEdit"
                @handleAdd="handleAdd"
                @handleEdit="handleEdit"
                @handleDelete="handleDelete"
                @handleClick="handleClick"
        />
      </v-flex>
  </v-card>
</template>

<script>
  export default {
    name: "category",
    data() {
      return {
        isEdit:true
      }
    },
    methods: {
      handleAdd(node) {
        this.$http.post("/item/category/add",{
            name: node.name,
            parentId: node.parentId,
            isParent: node.isParent,
            sort: node.sort
          })
      },
      handleEdit(id, name) {
        
        //debugger
        this.$http.post("/item/category/edit",{
          id:id,
          name:name
        })

      console.log("edit... id: " + id + ", name: " + name)
      },
      handleDelete(id) {
        console.log("delete ... " + id)
        this.$http.get("/item/category/delete",{
          params:{
            id:id
          }
        })
      },
      handleClick(node) {
        console.log(node)
      }
    }
  };
</script>

<style scoped>

</style>
