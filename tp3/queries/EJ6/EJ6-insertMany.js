use vaccination;
db.nurses.insertMany([
    {
        "name": "Gale Molina",
        "experience": 8,
        "vaccines": [
            "AZ",
            "Moderna"
        ]
    },
    {
        "name": "Honoria Fernández",
        "experience": 5,
        "vaccines": [
            "Pfizer",
            "Moderna",
            "Sputnik V"
        ]
    },
    {
        "name": "Gonzalo Gallardo",
        "experience": 3
    },
    {
        "name": "Altea Parra",
        "experience": 6,
        "vaccines": [
            "Pfizer"
        ]
    }
])