const axios = require("axios")
const defaultData = require("../defaultdata")
const Product = require("../models/productstructure")
const { uniqueNamesGenerator, Config, starWars } = require ('unique-names-generator');

class condidateController {

    async uploadAndResolveProduct(req,res) {
        console.log(req.file.filename)
        let api_result = null
        let Product_data;
        /*api_result = await axios.get(`https://api.apilayer.com/resume_parser/url?url=http://fff0-41-225-140-80.ngrok.io/api/Product/download/${req.file.filename}`,{
            headers:{
                "apikey":"gNoCFMNQBfLqUGoDtODxxbBX3qj2sMwM"
            },
        })*/
        if (api_result)
            Product_data = api_result.data
        else{
            Product_data = defaultData
            Product_data.name = uniqueNamesGenerator({
                dictionaries: [starWars]
              })
        }

        const created_data = await Product.create({raw_data:Product_data,path:req.file.path,fileName:req.file.filename})
        
        try{
       // await axios.post("http://192.168.1.9:8083/Products/",Product_data)
        }catch(err){
            console.log(err)
        }
        Product_data._id = created_data._id       
        return res.json({status:"done",Product_data})
    }

    async downloadFile(req,res){
        const file = `./uploads/${req.params.name}`;
        return res.download(file);
    }

    async updateData(req,res){
        const payload = req.body
        const _id = req.body._id
        delete payload._id
        const updatedData = await cv.findOneAndUpdate({_id},{raw_data:payload},{new:true})
        return res.json({success:true,updatedData})
    }

    async deleteData(req,res){
        const {_id} = req.body
        await cv.deleteOne({_id})
        return res.json({success:true})
    }
}

module.exports = condidateController