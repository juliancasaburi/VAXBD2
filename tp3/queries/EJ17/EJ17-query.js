use vaccination;
db.nurses.aggregate(
    [
        {
            $match: { name: { $regex: '111' } }
        },
        {
            $lookup:
                {
                    from: "doses",
                    "let": {
                        n: "$name"
                    },
                    pipeline: [
                        {
                            "$match": {
                                $expr: {
                                    $and: [
                                        {
                                            $eq: [
                                                "$$n",
                                                "$nurse"
                                            ]
                                        },
                                        {
                                            $gt: [
                                                "$date",
                                                new ISODate("2021-05-01T00:00:00.000Z")
                                            ]
                                        }
                                    ]
                                }
                            }
                        }
                    ],
                    as: "doses"
                }
        },
        {
            $out : "ej17Nurses"
        }
    ]
)
