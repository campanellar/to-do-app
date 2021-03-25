import Vue from "vue";
// eslint-disable-next-line no-unused-vars
let app = new Vue({
  el: "#app",
  data: {
    title: 'ToDo List',
    
    lists: [
      /*{ id:1, item: 'do homework', completed: false},
      { id:2, item: 'do laundry', completed: false},
      { id:3, item: 'empty trash', completed: false}*/
    ],
    //localStorage.setItem("lists", JSON.stringify(lists)),
    newItem:'',
  },
  methods: {
    addItem(){
      let idd = this.lists.length+1
      const newList = {id:idd, item:this.newItem, completed:false}
      this.lists.push(newList)

      this.newItem = ''

      this.saveLists()
    },
    deleteItem(id){
      this.lists.splice(id, 1);

      this.saveLists()
    },
    saveLists(){
      const parsed = JSON.stringify(this.lists)
      localStorage.setItem('lists', parsed)
    },
    mark(list){
      if (list.completed)
        list.completed = false
      else
        list.completed = true
      this.saveLists()
    }
  },
  mounted() {
    /*if (localStorage.getItem('lists')) {
      this.lists = JSON.parse(localStorage.getItem('lists'));
    }*/
    if (localStorage.getItem('lists')) {
      try {
        this.lists = JSON.parse(localStorage.getItem('lists'));
      } catch(e) {
        localStorage.removeItem('lists');
      }
    }
  },
  watch: {
    newItem(/*item*/) {
      this.lists.saveLists();
    }
  }
})