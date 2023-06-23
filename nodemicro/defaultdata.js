module.exports = {
    name: 'Gaming PC Hardware Bundle',
    brand: 'ExampleBrand',
    price: 1500,
    description: 'A complete bundle of high-performance gaming PC hardware components.',
    components: [
        {
            name: 'Processor',
            brand: 'Intel',
            model: 'Core i7-9700K',
            socket: 'LGA 1151',
            cores: 8,
            threads: 8,
            baseClock: '3.6GHz',
            boostClock: '4.9GHz'
        },
        {
            name: 'Graphics Card',
            brand: 'NVIDIA',
            model: 'GeForce RTX 3080',
            vram: '10GB GDDR6X',
            coreClock: '1440MHz',
            boostClock: '1710MHz',
            memoryClock: '19Gbps'
        },
        {
            name: 'RAM',
            brand: 'Corsair',
            capacity: '16GB',
            speed: '3200MHz',
            type: 'DDR4'
        },
        {
            name: 'Storage',
            brand: 'Samsung',
            capacity: '1TB',
            type: 'NVMe SSD'
        },
        {
            name: 'Power Supply',
            brand: 'EVGA',
            wattage: '750W',
            efficiencyRating: '80 Plus Gold',
            modular: true
        },
        {
            name: 'Motherboard',
            brand: 'ASUS',
            model: 'ROG Strix Z390-E Gaming',
            socket: 'LGA 1151',
            formFactor: 'ATX',
            chipset: 'Intel Z390',
            memorySlots: 4
        },
        {
            name: 'Cooling',
            brand: 'NZXT',
            type: 'Liquid Cooler',
            radiatorSize: '240mm',
            fanSpeed: '500-2000 RPM',
            noiseLevel: '21-36 dBA'
        },
        {
            name: 'Case',
            brand: 'Phanteks',
            model: 'Eclipse P400',
            formFactor: 'Mid Tower',
            color: 'Black',
            sidePanel: 'Tempered Glass'
        }
    ]
};
