const express = require("express");
const router = express.Router();
const prodcutRoutes = require("./product");


router.use("/api/product", prodcutRoutes);

router.use((req, res, next) => {
  next({
    status: 404,
  });
});

module.exports = router;