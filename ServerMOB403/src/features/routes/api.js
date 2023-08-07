const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const Product = require('../../models/product');
const User = require('../../models/User');

const router = express.Router();

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());

router.get('/signup', async (req, res) => {
    // const nameDb = req.body.name;
    // mongoose.createConnection(nameDb);
    try {
        mongoose.createConnection('siball')
    } catch {

    }
})

router.get('/', (req, res) => {
    res.json('result');
});



router.get('/getProduct', async (req, res) => {
    await Product.find().lean()
    .then((list)=> res.json({
        result: 'success',
        message: 'Register successfull',
        list: list
    }));
});



router.post('/addProduct', (req, res) => {
    const { id, name, type, condition, lifespan, price, detail, postDate, seller } = req.body;
    try {
        const product = new Product({ id: id, name: name, type: type, condition: condition, lifespan: lifespan, price: price, detail: detail, postDate: postDate, seller: seller });
        product.save().then((result) => res.json(result));
    } catch (err) {
        res.status(422).send(err.message);
    }

});
router.get('/:id/deleteProduct', (req, res) => {
    Product.findOneAndRemove({ _id: req.params.id })
        .then(result => {
            console.log(result);
            res.json(result)
        })
})

/// lab4

router.post('/addUser', (req, res) => {
    const { operation, user } = req.body;
    try {
        addUser = new User({ user: user });
        addUser.save().then(() => res.json({
            result: 'success',
            message: 'Register successfull',
        }));
        console.log(req.body)
    } catch (err) {
        res.json({
            result: 'failed',
            message: 'Register faild',
        })
    }
});
router.post('/login', async (req, res) => {
    const { email, password } = req.body;
    try {
        const user = await User.findOne({ 'user.email': email, 'user.password': password });
        if (user) {
            res.status(200).json({ result: 'success', message: 'OK Baybe' });
        } else {
            res.status(404).json({ result: 'error', message: 'User not found' });
        }
    } catch (err) {
        console.error(err);
        res.status(500).json({ result: 'error', msg: 'Internal server error' });
    }
});

router.get('/getUsersss', (req, res) => {
    const userList = [
        { id: 1, name: 'John Doe', email: 'john@example.com', password: 'password1' },
        { id: 2, name: 'Jane Smith', email: 'jane@example.com', password: 'password2' },
        // Add more users as needed
    ];
    res.json(userList);
});
router.get('/getUser', async (req, res) => {
    const userList = await User.find().lean();
    res.json(userList);
});

router.get('/getProducts', (req, res) => {
    const userList = [
        { id: "1", name: 'John Doe', price: 120000 },
        { id: "2", name: 'John Doe', price: 120000 },
        { id: "3", name: 'John Doe', price: 120000 },
        { id: "4", name: 'John Doe', price: 120000 },


    ];
    res.json(userList);
});



module.exports = router;
