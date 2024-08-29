const express = require("express");
const mongoose = require("mongoose");
const Item = require("./models/Item");

const app = express();
const port = 3000;

mongoose.connect('mongodb://localhost:27017/ecommerceDB')
.then(()=> console.log("Connected to MongoDB"))
.catch(err => console.log("Err to connect: ", err));
