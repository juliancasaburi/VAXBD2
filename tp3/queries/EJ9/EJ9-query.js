use vaccination;
db.nurses.updateOne( { name: "Altea Parra" }, { $push: { vaccines: "AZ" } })