use vaccination;
db.patients.createIndex({address:"2dsphere"})
