const express = require("express");
const productController = require("../controller/product.controller");

const router = express.Router();

router.post("/", productController.createProduct);
router.get("/", productController.getProduct);
router.put("/:id", productController.updateProduct);
router.delete("/:id", productController.deleteProduct);



module.exports = router;
