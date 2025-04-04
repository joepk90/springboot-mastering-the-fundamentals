DELIMITER $$
-- delimter altered so that multiple statements can be executed inthe begin and end block below

CREATE PROCEDURE `findProductsByPrice` (
    minPrice DECIMAL(10,2),
    maxPrice DECIMAL(10,2)
)

BEGIN
    SELECT id, name, description, price, category_id
    FROM products
    WHERE price BETWEEN minPrice AND maxPrice
    ORDER BY name;
END $$

DELIMITER ;
-- reset the delimiter back to default
-- this is important to avoid syntax errors in the rest of the script

