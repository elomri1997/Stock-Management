const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;
//const eurekaHelper = require('./eureka-helper');
const bodyParser = require('body-parser');
const cors = require("cors");
const mongoose = require("mongoose")

const swaggerUi = require("swagger-ui-express"),
swaggerDocument = require("./swagger.json");
app.use(
  '/api-docs',
  swaggerUi.serve, 
  swaggerUi.setup(swaggerDocument)
);

app.use(bodyParser.urlencoded({
  extended: false
}));



app.use(bodyParser.json());
app.use(cors());
app.get('/', (req, res) => {
  res.json("I am user-service")
 })
app.use(require('./routes/index'));



app.listen(PORT, () => {
  console.log(`user-service on ${PORT}`);
  mongoose.connect('mongodb+srv://esprit:B1eV2f90yJpSynim@espritmicro.ffubwew.mongodb.net/Esprit?retryWrites=true&w=majority').then(()=>
    console.log("mongoDB connected")
  ).catch(err => {
    console.log(err)
  })
})


//eurekaHelper.registerWithEureka('nodemicro', PORT);