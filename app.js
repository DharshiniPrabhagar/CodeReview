import React from 'react'

function app(){
  const [nm,setnm]=React.useState('')
  const [lst,setlst]=React.useState([])

  function addname(){
    if(nm!==''){
      setlst([...lst,nm])
      setnm('')
    }
  }

  return(<div>
    <h1>namelist</h1>
    <input value={nm} onChange={e=>setnm(e.target.value)}/>
    <button onClick={addname}>Add</button>
    <ul>
      {lst.map((n,i)=><li key={i}>{n}</li>)}
    </ul>
  </div>)
}

export default app
