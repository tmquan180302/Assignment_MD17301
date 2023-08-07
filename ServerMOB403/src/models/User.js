const mongoose = require('mongoose');
// schema
const schema = mongoose.Schema;
const userSchema = new schema({


    // Một model chứa child object 
    //>>>>>>
    // operation:{
    //     type: String,
    // },
    // user: {
    //     name: { type: String, },
    //     email: { type: String, },
    //     password: { type: String, }
    // },
    //>>>>>>
    user: {
        name: {
            type: String,
            required: true
        },
        email: {
            type: String,
            required: true
        },
        password: {
            type: String,
            required: true
        },
    }
})

// Model
const User = mongoose.model('User', userSchema);

module.exports = User;