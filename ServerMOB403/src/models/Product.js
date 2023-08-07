const mongoose = require('mongoose');
const currentDate = new Date(Date.now());
// schema
const schema = mongoose.Schema;
const productSchema = new schema({

    id: {
        type: String,
        required: true,
    },
    name: {
        type: String,
        required: true,
    },  
    type: {
        type: String,
        required: true,
    },
    condition: {
        type: String,
        required: true,
    },
    lifespan: {
        type: String,
        required: true,
    },
    price: {
        type: Number,
        required: true,
    },
    detail: {
        type: String,
        required: true,
    },
    postDate: {
        type: String,
        default: ` ${currentDate.getHours()}:${currentDate.getMinutes()} : ${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`
    },
    seller: {
        type: String,
        required: true,
    },
    
    
    


})

// Model
const Product = mongoose.model('Product', productSchema);

module.exports = Product;