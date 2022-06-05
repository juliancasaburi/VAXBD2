use vaccination;
db.doses.aggregate([
    {
        $lookup:
            {
                from: "cabaPatients",
                localField: "patient",
                foreignField: "name",
                as: "luPatient"
            },
    },
    {
        $match: {
            "luPatient": {$ne: []}
        }
    },
    {
        $project: {"luPatient": 0}
    }
]);