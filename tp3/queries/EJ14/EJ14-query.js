use vaccination;
db.patients.aggregate([{ $sample: { size: 5 } }]);