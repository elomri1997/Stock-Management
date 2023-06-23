const express = require("express");
const router = express.Router();
const prodcutRoutes = require("./product");
/*const friendRequestRoutes = require("./friendRequest");
const verifProfilRoutes = require("./verifProfil");
const categoryRoutes = require("./category");
const efileRoutes = require("./efile");*/

router.use("/api/product", prodcutRoutes);
/*router.use("/api/friendRequest", friendRequestRoutes);
router.use("/api/verifProfil", verifProfilRoutes);
router.use("/api/category", categoryRoutes);
router.use("/api/efile", efileRoutes);*/

router.use((req, res, next) => {
  next({
    status: 404,
  });
});

module.exports = router;