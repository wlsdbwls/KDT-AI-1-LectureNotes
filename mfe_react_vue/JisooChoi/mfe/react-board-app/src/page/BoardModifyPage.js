import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/board.js"
import BoardModifyForm from '../components/BoardModifyForm'

const BoardModifyPage = () => {
    const {boardId} = useParams()

    const [board, setBoard] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const onModify = async (boardId, title, content, writer) => {
        try{
            await axiosClient.modifyBoard(boardId, title, content, writer)
            alert("게시물이 성공적으로 수정되었습니다.")
            navigate("/read/" + boardId)
        } catch (e) {
            console.log(e)
        }
    }

    const readBoard = async (boardId) => {
        setLoading(true)

        try{
            const response = await axiosClient.fetchBoard(boardId)
            setBoard(response.data)
            setLoading(false)
        } catch (e) {
            throw e
        }
    }

    useEffect(() => {
        readBoard(boardId)
    }, [boardId])

    return (
        <BoardModifyForm board={board} isLoading={isLoading} onModity={onModify}/>
    )
}

export default BoardModifyPage