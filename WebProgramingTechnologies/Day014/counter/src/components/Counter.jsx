import { useState } from "react";


const Counter = () => {

    const [count, setCount] = useState(100)

    const handleIncrement = () => {
        setCount(count + 1);
    }

    const handleDecrement = () => {
        if (count < 1) {
            setCount(0)
        } else {
            setCount(count - 1);

        }
    }


    const handleResetCount = () => {
        setCount(0);
    }



    return (
        <>
            <div className='flex justify-center flex-col gap-20 items-center h-[500px]'>
                <h1 className='text-2xl font-semibold '>Counter  {count} </h1>


                <div className='flex gap-5 '>
                    < button onClick={handleIncrement} className='bg-blue-500 py-2 px-3 rounded-full text-white hover:bg-blue-600 cursor-pointer  text-md'>Increment Count</button>
                    < button onClick={handleDecrement} className='bg-red-500 py-2 px-3 rounded-full text-white hover:bg-red-600 cursor-pointer text-md' >Decrement Count</button>
                    < button onClick={handleResetCount} className='bg-green-500 py-2 px-3 rounded-full text-white hover:bg-green-600 cursor-pointer text-md' >Decremnt Count</button>
                </div>
            </div>
        </>
    )
}

export default Counter