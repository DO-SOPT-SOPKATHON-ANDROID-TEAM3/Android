package org.sopt.sopkaton_team3.presentation

import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.presentation.model.Slot

class SlotViewModel : ViewModel() {
    val l1 = listOf<Slot>(
        Slot("윤한이와"),
        Slot("윤한이와"),
        Slot("윤한이와"),
        Slot("윤한이와"),
        Slot("윤한이와"),
        Slot("윤한이와"),
    )

    val l2 = listOf<Slot>(
        Slot("솝트에서"),
        Slot("솝트에서"),
        Slot("솝트에서"),
        Slot("솝트에서"),
        Slot("솝트에서"),
        Slot("솝트에서"),
    )

    val l3 = listOf<Slot>(
        Slot("술먹기"),
        Slot("술먹기"),
        Slot("술먹기"),
        Slot("술먹기"),
        Slot("술먹기"),
        Slot("술먹기"),
    )
    val list1 = listOf<Slot>(
        Slot(
            "혼자서"
        ),
        Slot(
            "PT 트레이너와"
        ),
        Slot(
            "초록색 양말을 신은 사람과"
        ),
        Slot(
            "골라준 사람과"
        ),
        Slot(
            "오랫동안 연락끊긴 친구와"
        ),
        Slot(
            "가장 친한 친구와"
        ),
    )

    val list2 = listOf<Slot>(
        Slot(
            "인천에서"
        ),
        Slot(
            "양양에서"
        ),
        Slot(
            "평양에서"
        ),
        Slot(
            "계왕산 에서"
        ),
        Slot(
            "청계천 에서"
        ),
        Slot(
            "백령동굴 에서"
        ),
    )

    val list3 = listOf<Slot>(
        Slot(
            "갯벌체험 하기"
        ),
        Slot(
            "클라이밍 하기"
        ),
        Slot(
            "함흥냉면 하기"
        ),
        Slot(
            "백숙 얻어먹기"
        ),
        Slot(
            "릴스찍기"
        ),
        Slot(
            "당연하지 게임하기"
        ),
    )
}