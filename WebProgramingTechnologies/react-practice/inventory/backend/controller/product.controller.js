const dbConnection = require("../dbconfig/db");


class ProductController {

    createProduct(req, res) {
        const { name, price, quantity, category } = req.body;
        try {
            dbConnection.query("INSERT INTO products(name,price,quantity,category) values (?,?,?,?)", [name, price, quantity, category], (err, result) => {
                if (err) {
                    console.error("Error inserting product:", err);
                    return res.status(500).json({ error: "Internal Server Error" });
                }
                res.status(201).json({
                    message: "Product created successfully",
                    data: req.body
                });
            });

        } catch (error) {
            res.status(500).json({ error: "Internal Server Error" });
        }
    }

    deleteProduct(req, res) {
        const { id } = req.params;

        try {
            dbConnection.query(
                "SELECT * FROM products WHERE id = ?",
                [id],
                (err, rows) => {
                    if (err) {
                        console.error("Error checking product:", err);
                        return res.status(500).json({ error: "Internal Server Error" });
                    }

                    if (rows.length === 0) {
                        return res.status(404).json({ message: "Product not found" });
                    }

                    dbConnection.query(
                        "DELETE FROM products WHERE id = ?",
                        [id],
                        (err, result) => {
                            if (err) {
                                console.error("Error deleting product:", err);
                                return res.status(500).json({ error: "Internal Server Error" });
                            }

                            return res.status(200).json({
                                message: "Product deleted successfully"
                            });
                        }
                    );
                }
            );
        } catch (error) {
            return res.status(500).json({ error: "Internal Server Error" });
        }
    }


    updateProduct(req, res) {

        const { id } = req.params;
        const { name, price, quantity, category } = req.body;
        try {
            dbConnection.query("UPDATE products SET name=?, price=?, quantity=?, category=? WHERE id=?", [name, price, quantity, category, id], (err, result) => {
                if (err) {
                    console.error("Error updating product:", err);
                    return res.status(500).json({ error: "Internal Server Error" });
                }
                res.status(200).json({
                    message: "Product updated successfully",
                    data: req.body
                });
            });

        }
        catch (error) {
            res.status(500).json({ error: "Internal Server Error" });
        }

    }

    getProduct(req, res) {
        try {
            dbConnection.query("SELECT * FROM products", (err, results) => {
                if (err) {
                    console.error("Error fetching products:", err);
                    return res.status(500).json({ error: "Internal Server Error" });
                }
                res.status(200).json({
                    data: results
                });
            }
            );
        } catch (error) {
            res.status(500).json({ error: "Internal Server Error" });
        }

    }

}

module.exports = new ProductController();