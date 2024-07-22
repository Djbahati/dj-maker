const axios = require('axios');
const config = require('../config');
const baseUrl = 'https://api.africastalking.com/version1/';
require('dotenv').config()


const credentials = {
    apiKey: process.env.AFRICA_TALKING_API_KEY,
    username: process.env.AFRICA_TALKING_USERNAME
  };

  const AfricasTalking = require("africastalking")(credentials);
  const sms = AfricasTalking.SMS;

const sendSMS = (message) => {
    sms.send({
        to: '+250780455033', 
        message: message,
        enqueue: true
    })
    .then(response => {
        console.log(response);
    })
    .catch(error => {
        console.log(error);
    });
};


const handleUSSD = (text, phoneNumber) => {
    let response = '';
    let smsMessage = '';

    if (text === '') {
        response = 'CON Welcome to XTour\n1. Continue\n2. Exit';
    } else if (text === '1') {
        response = 'CON Select the country you want to visit\n1. Rwanda\n2. Kenya\n3. Tanzania';
    } else if (text === '2') {
        response = 'END Thank you for using Tourism Info. Goodbye!';
    } else if (text === '1*1') {
        response = 'CON Choose what to visit in Rwanda\n1. National Park\n2. Cultural Centers\n3. Attractive Sites';
    } else if (text === '1*2') {
        response = 'CON Choose what to visit in Kenya\n1. National Park\n2. Cultural Centers\n3. Attractive Sites';
    } else if (text === '1*3') {
        response = 'CON Choose what to visit in Tanzania\n1. National Park\n2. Cultural Centers\n3. Attractive Sites';
    } else if (text === '1*1*1') {
        response = 'CON Choose National Park in Rwanda\n1. Akagera National Park\n2. Nyandungu Eco-Park\n3. Volcano National Park';
    } else if (text === '1*1*2') {
        response = 'CON Choose Cultural Centers in Rwanda\n1. Kigali Genocide Memorial\n2. Ethnographic Museum\n3. Rwandan Art Museum';
    } else if (text === '1*1*3') {
        response = 'CON Choose Attractive Sites in Rwanda\n1. Lake Kivu\n2. Gisozi Memorial Center\n3. Inema Art Center';
    } else if (text === '1*2*1') {
        response = 'CON Choose National Park in Kenya\n1. Maasai Mara\n2. Amboseli National Park\n3. Tsavo National Park';
    } else if (text === '1*2*2') {
        response = 'CON Choose Cultural Centers in Kenya\n1. Karen Blixen Museum\n2. Nairobi National Museum\n3. Maasai Cultural Center';
    } else if (text === '1*2*3') {
        response = 'CON Choose Attractive Sites in Kenya\n1. Diani Beach\n2. Giraffe Centre\n3. Bomas of Kenya';
    } else if (text === '1*3*1') {
        response = 'CON Choose National Park in Tanzania\n1. Serengeti National Park\n2. Ngorongoro Crater\n3. Tarangire National Park';
    } else if (text === '1*3*2') {
        response = 'CON Choose Cultural Centers in Tanzania\n1. National Museum of Tanzania\n2. Mwenge Carvers Market\n3. Stone Town';
    } else if (text === '1*3*3') {
        response = 'CON Choose Attractive Sites in Tanzania\n1. Zanzibar Beaches\n2. Mount Kilimanjaro\n3. Selous Game Reserve';
    } else if (text === '1*1*1*1') {
        response = 'END Thank you for your interest in Akagera National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Akagera National Park features: 
Location: Rwanda 
Street number: N/A (Akagera National Park is located in the eastern part of Rwanda, bordering Tanzania) 
Language: Kinyarwanda, English, French 
Culture description: Akagera National Park showcases Rwanda's rich biodiversity and the cultural heritage of the local communities living near the park. Visitors can experience traditional Rwandan culture, including local crafts and dances. 
Climate: The climate is warm with two main seasons – a long dry season from June to September and a short dry season in January and February. The wet seasons are from March to May and from October to December. 
Estimate pocket money: $100 - $300 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Akagera Game Lodge - Booking Link (Use promo code 9666 for a discount!) Ruzizi Tented Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Development Board (in charge of the park): +250 788 721 000 
        `;
    } else if (text === '1*1*1*2') {
        response = 'END Thank you for your interest in Nyandungu Eco-Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Nyandungu Eco-Park features: 
Location: Rwanda 
Street number: N/A (Nyandungu Eco-Park is located in Kigali, Rwanda) 
Language: Kinyarwanda, English, French 
Culture description: Nyandungu Eco-Park is a restored wetland area in Kigali that offers visitors a chance to enjoy nature trails, bird watching, and learn about wetland conservation efforts. 
Climate: Kigali has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Kigali Marriott Hotel - Booking Link (Use promo code 9666 for a discount!) Radisson Blu Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Environment Management Authority: +250 788 715 243 
        `;
    } else if (text === '1*1*1*3') {
        response = 'END Thank you for your interest in Volcano National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Volcano National Park features: 
Location: Rwanda 
Street number: N/A (Volcano National Park is located in the northwestern part of Rwanda) 
Language: Kinyarwanda, English, French 
Culture description: Volcano National Park is known for its population of mountain gorillas and the Virunga volcanic mountains. It offers a unique experience of trekking to see the gorillas and learning about their conservation. 
Climate: The climate is cool due to the high altitude, with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $300 - $600 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Bisate Lodge - Booking Link (Use promo code 9666 for a discount!) Virunga Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Development Board (in charge of the park): +250 788 721 000 
        `;
    } else if (text === '1*1*2*1') {
        response = 'END Thank you for your interest in Kigali Genocide Memorial. You will receive information shortly.';
        smsMessage = `
         Hello, explore Kigali Genocide Memorial features: 
Location: Kigali, Rwanda 
Language: Kinyarwanda, English, French 
Culture description: The Kigali Genocide Memorial is a poignant site dedicated to the victims of the 1994 Rwandan genocide. It provides a comprehensive history of the genocide and honors the memory of those who lost their lives. 
Climate: Kigali has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Hotel des Mille Collines - Booking Link (Use promo code 9666 for a discount!) Radisson Blu Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Tourism Board: +250 788 721 000 
        `;
    } else if (text === '1*1*2*2') {
        response = 'END Thank you for your interest in Ethnographic Museum. You will receive information shortly.';
        smsMessage = `
         Hello, explore Ethnographic Museum features: 
Location: Huye, Rwanda 
Language: Kinyarwanda, English, French 
Culture description: The Ethnographic Museum in Huye provides insights into Rwanda's cultural history and traditions, showcasing artifacts, traditional clothing, and various aspects of Rwandan life. 
Climate: The climate in Huye is temperate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Hotel Ibis - Booking Link (Use promo code 9666 for a discount!) Light House Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Tourism Board: +250 788 721 000 
        `;
    } else if (text === '1*1*2*3') {
        response = 'END Thank you for your interest in Rwandan Art Museum. You will receive information shortly.';
        smsMessage = `
         Hello, explore Rwandan Art Museum features: 
Location: Kigali, Rwanda 
Language: Kinyarwanda, English, French 
Culture description: The Rwandan Art Museum, located at the former Presidential Palace, showcases contemporary Rwandan art and a historical look at the residence of the former president. 
Climate: Kigali has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Kigali Marriott Hotel - Booking Link (Use promo code 9666 for a discount!) Radisson Blu Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 911 
Rwanda Tourism Board: +250 788 721 000 
        `;
    } else if (text === '1*2*1*1') {
        response = 'END Thank you for your interest in Maasai Mara. You will receive information shortly.';
        smsMessage = `
         Hello, explore Maasai Mara features: 
Location: Kenya 
Street number: N/A (Maasai Mara is located in southwestern Kenya) 
Language: Swahili, English 
Culture description: Maasai Mara is known for its exceptional wildlife, including the Great Migration of wildebeest and zebra. It is also home to the Maasai people, who maintain their traditional way of life. 
Climate: The climate is generally warm with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $200 - $500 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Mara Serena Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Ashnil Mara Camp - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Tourism Board: +254 20 221 1248 
        `;
    } else if (text === '1*2*1*2') {
        response = 'END Thank you for your interest in Amboseli National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Amboseli National Park features: 
Location: Kenya 
Street number: N/A (Amboseli National Park is located in southern Kenya) 
Language: Swahili, English 
Culture description: Amboseli National Park is famous for its large herds of elephants and stunning views of Mount Kilimanjaro. It offers a unique opportunity to experience the diverse wildlife of Kenya. 
Climate: The climate is generally warm with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $200 - $500 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Amboseli Serena Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Ol Tukai Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Wildlife Service: +254 20 600 800 
        `;
    } else if (text === '1*2*1*3') {
        response = 'END Thank you for your interest in Tsavo National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Tsavo National Park features: 
Location: Kenya 
Street number: N/A (Tsavo National Park is located in southeastern Kenya) 
Language: Swahili, English 
Culture description: Tsavo National Park is one of the largest parks in Kenya, known for its diverse landscapes and wildlife. It is divided into Tsavo East and Tsavo West, each offering unique experiences. 
Climate: The climate is generally warm with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $200 - $500 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Kilaguni Serena Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Finch Hattons Luxury Camp - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Wildlife Service: +254 20 600 800 
        `;
    } else if (text === '1*2*2*1') {
        response = 'END Thank you for your interest in Karen Blixen Museum. You will receive information shortly.';
        smsMessage = `
         Hello, explore Karen Blixen Museum features: 
Location: Nairobi, Kenya 
Language: Swahili, English 
Culture description: The Karen Blixen Museum is the former home of the famous Danish author of "Out of Africa". It offers a glimpse into the colonial history of Kenya and the life of Karen Blixen. 
Climate: Nairobi has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Hemingways Nairobi - Booking Link (Use promo code 9666 for a discount!) Giraffe Manor - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Tourism Board: +254 20 271 1262 
        `;
    } else if (text === '1*2*2*2') {
        response = 'END Thank you for your interest in Nairobi National Museum. You will receive information shortly.';
        smsMessage = `
         Hello, explore Nairobi National Museum features: 
Location: Nairobi, Kenya 
Language: Swahili, English 
Culture description: The Nairobi National Museum offers a comprehensive overview of Kenya's cultural and natural heritage, including exhibits on archaeology, paleontology, and contemporary art. 
Climate: Nairobi has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Nairobi Serena Hotel - Booking Link (Use promo code 9666 for a discount!) Villa Rosa Kempinski - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya National Museums: +254 20 374 2131 
        `;
    } else if (text === '1*2*2*3') {
        response = 'END Thank you for your interest in Maasai Cultural Center. You will receive information shortly.';
        smsMessage = `
         Hello, explore Maasai Cultural Center features: 
Location: Narok, Kenya 
Language: Swahili, English 
Culture description: The Maasai Cultural Center offers an authentic experience of the Maasai people's traditional way of life, including their customs, dances, and crafts. 
Climate: Narok has a warm climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $50 - $100 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Keekorok Lodge - Booking Link (Use promo code 9666 for a discount!) Mara Sopa Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Tourism Board: +254 20 271 1262 
        `;
    } else if (text === '1*2*3*1') {
        response = 'END Thank you for your interest in Diani Beach. You will receive information shortly.';
        smsMessage = `
         Hello, explore Diani Beach features: 
Location: Kwale, Kenya 
Language: Swahili, English 
Culture description: Diani Beach is a popular coastal destination known for its white sandy beaches, clear blue waters, and vibrant nightlife. It offers a range of water sports and cultural experiences. 
Climate: The climate is generally warm and humid, with two main rainy seasons from March to May and October to December. 
Estimate pocket money: $100 - $300 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Baobab Beach Resort - Booking Link (Use promo code 9666 for a discount!) Diani Reef Beach Resort - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Tourism Board: +254 20 271 1262 
        `;
    } else if (text === '1*2*3*2') {
        response = 'END Thank you for your interest in Giraffe Centre. You will receive information shortly.';
        smsMessage = `
         Hello, explore Giraffe Centre features: 
Location: Nairobi, Kenya 
Language: Swahili, English 
Culture description: The Giraffe Centre in Nairobi is dedicated to the conservation of the endangered Rothschild giraffe. Visitors can learn about giraffes and feed them in a natural setting. 
Climate: Nairobi has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Giraffe Manor - Booking Link (Use promo code 9666 for a discount!) Nairobi Serena Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Wildlife Service: +254 20 600 800 
        `;
    } else if (text === '1*2*3*3') {
        response = 'END Thank you for your interest in Bomas of Kenya. You will receive information shortly.';
        smsMessage = `
         Hello, explore Bomas of Kenya features: 
Location: Nairobi, Kenya 
Language: Swahili, English 
Culture description: Bomas of Kenya showcases the traditional dances, music, and lifestyle of Kenya's diverse ethnic groups. It offers a cultural experience through performances and exhibitions. 
Climate: Nairobi has a temperate climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Nairobi Serena Hotel - Booking Link (Use promo code 9666 for a discount!) Villa Rosa Kempinski - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 999 
Kenya Tourism Board: +254 20 271 1262 
        `;
    } else if (text === '1*3*1*1') {
        response = 'END Thank you for your interest in Serengeti National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Serengeti National Park features: 
Location: Tanzania 
Street number: N/A (Serengeti National Park is located in northern Tanzania) 
Language: Swahili, English 
Culture description: Serengeti National Park is famous for its annual migration of over 1.5 million wildebeest and 250,000 zebra. It offers an unparalleled wildlife viewing experience. 
Climate: The climate is generally warm with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $300 - $600 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Serengeti Serena Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Four Seasons Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania National Parks: +255 27 250 3471 
        `;
    } else if (text === '1*3*1*2') {
        response = 'END Thank you for your interest in Ngorongoro Crater. You will receive information shortly.';
        smsMessage = `
         Hello, explore Ngorongoro Crater features: 
Location: Tanzania 
Street number: N/A (Ngorongoro Crater is located in northern Tanzania) 
Language: Swahili, English 
Culture description: The Ngorongoro Crater is a UNESCO World Heritage site and home to a diverse range of wildlife, including the Big Five. It offers a unique safari experience within a volcanic caldera. 
Climate: The climate is generally cool due to the high altitude, with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $300 - $600 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Ngorongoro Serena Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Ngorongoro Crater Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania National Parks: +255 27 250 3471 
        `;
    } else if (text === '1*3*1*3') {
        response = 'END Thank you for your interest in Tarangire National Park. You will receive information shortly.';
        smsMessage = `
         Hello, explore Tarangire National Park features: 
Location: Tanzania 
Street number: N/A (Tarangire National Park is located in northern Tanzania) 
Language: Swahili, English 
Culture description: Tarangire National Park is known for its large herds of elephants and ancient baobab trees. It offers a diverse wildlife experience with many migratory animals during the dry season. 
Climate: The climate is generally warm with two main rainy seasons – long rains from March to May and short rains from October to December. 
Estimate pocket money: $200 - $500 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Tarangire Safari Lodge - Booking Link (Use promo code 9666 for a discount!) Tarangire Treetops - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania National Parks: +255 27 250 3471 
        `;
    } else if (text === '1*3*2*1') {
        response = 'END Thank you for your interest in National Museum of Tanzania. You will receive information shortly.';
        smsMessage = `
         Hello, explore National Museum of Tanzania features: 
Location: Dar es Salaam, Tanzania 
Language: Swahili, English 
Culture description: The National Museum of Tanzania in Dar es Salaam offers a rich display of Tanzania's history and culture, including exhibits on human evolution, natural history, and ethnography. 
Climate: Dar es Salaam has a tropical climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Hyatt Regency Dar es Salaam - Booking Link (Use promo code 9666 for a discount!) Sea Cliff Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania Tourism Board: +255 22 213 4917 
        `;
    } else if (text === '1*3*2*2') {
        response = 'END Thank you for your interest in Mwenge Carvers Market. You will receive information shortly.';
        smsMessage = `
         Hello, explore Mwenge Carvers Market features: 
Location: Dar es Salaam, Tanzania 
Language: Swahili, English 
Culture description: Mwenge Carvers Market is a vibrant marketplace where visitors can find traditional Tanzanian crafts, including wood carvings, paintings, and jewelry. It is a great place to buy souvenirs and learn about local craftsmanship. 
Climate: Dar es Salaam has a tropical climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Hyatt Regency Dar es Salaam - Booking Link (Use promo code 9666 for a discount!) Sea Cliff Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania Tourism Board: +255 22 213 4917 
        `;
    } else if (text === '1*3*2*3') {
        response = 'END Thank you for your interest in Stone Town. You will receive information shortly.';
        smsMessage = `
         Hello, explore Stone Town features: 
Location: Zanzibar, Tanzania 
Language: Swahili, English 
Culture description: Stone Town is a historic city and cultural heart of Zanzibar, known for its winding alleys, bustling bazaars, and grand Arab houses. It offers a unique blend of Arab, Persian, Indian, and European influences. 
Climate: Zanzibar has a tropical climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $50 - $100 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Park Hyatt Zanzibar - Booking Link (Use promo code 9666 for a discount!) Emerson Spice Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Zanzibar Tourism Board: +255 24 223 3488 
        `;
    } else if (text === '1*3*3*1') {
        response = 'END Thank you for your interest in Zanzibar Beaches. You will receive information shortly.';
        smsMessage = `
         Hello, explore Zanzibar Beaches features: 
Location: Zanzibar, Tanzania 
Language: Swahili, English 
Culture description: Zanzibar's beaches are renowned for their white sands, turquoise waters, and vibrant marine life. Popular beaches include Nungwi, Kendwa, and Paje, offering a range of water sports and relaxation options. 
Climate: Zanzibar has a tropical climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $100 - $300 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Zuri Zanzibar - Booking Link (Use promo code 9666 for a discount!) The Residence Zanzibar - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Zanzibar Tourism Board: +255 24 223 3488 
        `;
    } else if (text === '1*3*3*2') {
        response = 'END Thank you for your interest in Mount Kilimanjaro. You will receive information shortly.';
        smsMessage = `
         Hello, explore Mount Kilimanjaro features: 
Location: Kilimanjaro Region, Tanzania 
Language: Swahili, English 
Culture description: Mount Kilimanjaro is the highest peak in Africa and a popular destination for trekkers and climbers. It offers a unique opportunity to experience diverse ecosystems from tropical rainforest to alpine desert. 
Climate: The climate varies with altitude, ranging from tropical at the base to arctic at the summit. The best time to climb is during the dry seasons from January to March and June to October. 
Estimate pocket money: $1,000 - $2,000 per trek (depending on the route and services) 
Nearby hotel and accommodation: 
Kilimanjaro Mountain Resort - Booking Link (Use promo code 9666 for a discount!) Marangu Hotel - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania National Parks: +255 27 250 3471 
        `;
    } else if (text === '1*3*3*3') {
        response = 'END Thank you for your interest in Bagamoyo. You will receive information shortly.';
        smsMessage = `
         Hello, explore Bagamoyo features: 
Location: Bagamoyo, Tanzania 
Language: Swahili, English 
Culture description: Bagamoyo is a historic town known for its role in the East African slave trade. It offers a rich cultural heritage with historical sites, museums, and vibrant local markets. 
Climate: Bagamoyo has a tropical climate with two main rainy seasons from March to May and October to December, and a dry season from June to September. 
Estimate pocket money: $20 - $50 per day (depending on activities and accommodation preferences) 
Nearby hotel and accommodation: 
Bagamoyo Beach Resort - Booking Link (Use promo code 9666 for a discount!) Travellers Lodge - Booking Link (Use promo code 9666 for a discount!) Emergency number: 
Police: 112 
Tanzania Tourism Board: +255 22 213 4917 
        `;
    } else {
        response = 'Invalid input. Please try again.';
    }
    return { response, smsMessage };
  
}

module.exports = {
    sendSMS,
    handleUSSD
};