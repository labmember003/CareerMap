package com.falcon.careermap.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.falcon.careermap.NetworkFragment
import com.falcon.careermap.ProfessionDescriptionFragment
import com.falcon.careermap.ProffessionDetailsFragment
import com.falcon.careermap.R

val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

class SectionsPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ProfessionDescriptionFragment()
            1 -> NetworkFragment()
            else -> {
                ProffessionDetailsFragment()
            }
        }
    }


}


