const express = require("express");
const multer = require("multer");
const { v4: uuidv4 } = require('uuid');
const mime = require("mime")
const router = express.Router();
const ProductController = require("../controllers/ProductController")
const ProductControllerInst = new ProductController()

const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, './uploads');
    },
    filename: function (req, file, cb) {
        const uniqueFilename = uuidv4() + '.' + mime.getExtension(file.mimetype);
        cb(null, uniqueFilename);
    }
});

const upload = multer({ storage });

router.post("/uploadProduct",upload.single('file'),(req,res)=>{
    ProductControllerInst.uploadAndResolveProduct(req,res)
}) 
router.get("/download/:name",(req,res)=>{
    ProductControllerInst.downloadFile(req,res)
})
router.put("/update",(req,res)=>{
    ProductControllerInst.updateData(req,res)
})
router.delete("/delete",(req,res)=>{
    ProductControllerInst.deleteData(req,res)
})

module.exports = router;