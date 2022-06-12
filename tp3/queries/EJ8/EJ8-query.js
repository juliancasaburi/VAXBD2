use vaccination;
db.nurses.updateOne( { name: "Gonzalo Gallardo" }, { $set: { vaccines: [] } })