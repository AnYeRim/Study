
// MyFirstDialogDlg.cpp : 구현 파일
//
#include "stdafx.h"
#include "MyFirstDialog.h"
#include "MyFirstDialogDlg.h"
#include "afxdialogex.h"

#include <fstream>

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// 응용 프로그램 정보에 사용되는 CAboutDlg 대화 상자입니다.

class CAboutDlg : public CDialogEx
{
public:
	CAboutDlg();

// 대화 상자 데이터입니다.
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 지원입니다.

// 구현입니다.
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialogEx(CAboutDlg::IDD)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialogEx)
END_MESSAGE_MAP()


// CMyFirstDialogDlg 대화 상자




CMyFirstDialogDlg::CMyFirstDialogDlg(CWnd* pParent /*=NULL*/)
	: CDialogEx(CMyFirstDialogDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
	m_strContent = _T("");
}

void CMyFirstDialogDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_EDIT_CONTENT, m_strContent);
	DDV_MaxChars(pDX, m_strContent, 100);
	DDX_Control(pDX, IDC_LIST_CONTENT, m_listbox_content);
}

BEGIN_MESSAGE_MAP(CMyFirstDialogDlg, CDialogEx)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BUTTON_LOAD, &CMyFirstDialogDlg::OnBnClickedButtonLoad)
//	ON_BN_KILLFOCUS(IDC_BUTTON_LOAD, &CMyFirstDialogDlg::OnBnKillfocusButtonLoad)
	ON_BN_CLICKED(IDC_BUTTON_SAVE, &CMyFirstDialogDlg::OnBnClickedButtonSave)
	ON_BN_CLICKED(IDC_BUTTON_ADD, &CMyFirstDialogDlg::OnBnClickedButtonAdd)
	ON_BN_CLICKED(IDC_BUTTON_REMOVE, &CMyFirstDialogDlg::OnBnClickedButtonRemove)
END_MESSAGE_MAP()


// CMyFirstDialogDlg 메시지 처리기

BOOL CMyFirstDialogDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 시스템 메뉴에 "정보..." 메뉴 항목을 추가합니다.

	// IDM_ABOUTBOX는 시스템 명령 범위에 있어야 합니다.
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		BOOL bNameValid;
		CString strAboutMenu;
		bNameValid = strAboutMenu.LoadString(IDS_ABOUTBOX);
		ASSERT(bNameValid);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// 이 대화 상자의 아이콘을 설정합니다. 응용 프로그램의 주 창이 대화 상자가 아닐 경우에는
	//  프레임워크가 이 작업을 자동으로 수행합니다.
	SetIcon(m_hIcon, TRUE);			// 큰 아이콘을 설정합니다.
	SetIcon(m_hIcon, FALSE);		// 작은 아이콘을 설정합니다.

	// TODO: 여기에 추가 초기화 작업을 추가합니다.

	GetDlgItem(IDC_EDIT_CONTENT)->SetFocus();

	return FALSE;  // 포커스를 컨트롤에 설정하지 않으면 TRUE를 반환합니다.
}

void CMyFirstDialogDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialogEx::OnSysCommand(nID, lParam);
	}
}

// 대화 상자에 최소화 단추를 추가할 경우 아이콘을 그리려면
//  아래 코드가 필요합니다. 문서/뷰 모델을 사용하는 MFC 응용 프로그램의 경우에는
//  프레임워크에서 이 작업을 자동으로 수행합니다.

void CMyFirstDialogDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 그리기를 위한 디바이스 컨텍스트입니다.

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 클라이언트 사각형에서 아이콘을 가운데에 맞춥니다.
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 아이콘을 그립니다.
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

// 사용자가 최소화된 창을 끄는 동안에 커서가 표시되도록 시스템에서
//  이 함수를 호출합니다.
HCURSOR CMyFirstDialogDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}



void CMyFirstDialogDlg::OnBnClickedButtonLoad()
{
	// TODO: Add your control notification handler code here	
	//UpdateData(TRUE);
	//TRACE(_T("%s"), m_strContent);
	CString strBuf = _T("");
	GetDlgItemText(IDC_EDIT_CONTENT, strBuf);
	AfxMessageBox(strBuf);


	// stand library 
	/*
	std::wofstream ofile(_T("D:\\std_lib.txt"));

	if(ofile.is_open()){
		ofile << (LPCTSTR)strBuf;
		ofile.close();
	}*/

	// WIN32
	/*
	HANDLE hFile = CreateFile(_T("D:\\win32.txt"), GENERIC_WRITE, 0, NULL,
                       CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL); 
	    // 유니코드 텍스트 길이만큼 기록한다
	WriteFile(hFile, strBuf, strBuf.GetLength() * 2, &dwWrite, NULL);
    CloseHandle(hFile); // 이제 필요없어진 핸들은 닫는다
	*/

	// MFC
	CFile file;
	file.Open(_T("D:\\mfc.txt"), CFile::modeCreate|CFile::modeNoTruncate|CFile::modeWrite);
	file.Write(strBuf, strBuf.GetLength() * sizeof(TCHAR)); // 파일에 기록
	file.Close();
}

void CMyFirstDialogDlg::OnBnClickedButtonSave()
{
	// TODO: Add your control notification handler code here
	CString strBuf = _T("1234");
	SetDlgItemText(IDC_EDIT_CONTENT, strBuf);
}

CString RemoveBlanck(CString strBuf)
{
	CString str_2blank, str_blank;

	str_2blank.LoadString(IDS_STRING_2BLANK);
	str_blank.LoadString(IDS_STRING_BLANK);

	while(strBuf.Find(str_2blank)  != -1){
		strBuf.Replace(str_2blank, str_blank);
	}

	strBuf.TrimLeft(str_blank);
	strBuf.TrimRight(str_blank);

	return strBuf;
}


void CMyFirstDialogDlg::OnBnClickedButtonAdd()
{
	// TODO: Add your control notification handler code here
	CString strBuf = _T("");
	GetDlgItemText(IDC_EDIT_CONTENT, strBuf);

	strBuf = RemoveBlanck(strBuf);
	
	if(strBuf.IsEmpty()){
		AfxMessageBox(_T("값을 입력해주세요"));
		return;
	}

	m_listbox_content.AddString(strBuf);

	int index = m_listbox_content.GetCount() - 1;

	m_listbox_content.SetCurSel(index);
	// AfxMessageBox(strBuf+"가(이) 추가되었습니다");
}


void CMyFirstDialogDlg::OnBnClickedButtonRemove()
{
	// TODO: Add your control notification handler code here
	int index = m_listbox_content.GetCurSel();
	int count = m_listbox_content.GetCount();

	
	if(count == 0)
	{
		//AfxMessageBox(_T("더이상 삭제할 항목이 없습니다."));
		return;
	}
	/*
	if(index < 0)
	{
		AfxMessageBox(_T("리스트를 선택해주세요"));
		return;
	}
	*/
	
	
	CString strBuf = _T("");
	m_listbox_content.GetText(index, strBuf);

	int nResult = AfxMessageBox(strBuf + _T("가(이) 삭제하시겠습니까 ?"), MB_YESNO);

	if(nResult == IDYES)
	{
		m_listbox_content.DeleteString(index);

		if (index < count)
		{	
			if (index == 0)
			{
				m_listbox_content.SetCurSel(index);
			}
			else
			{
				m_listbox_content.SetCurSel(index - 1);
			}
		
		}
	}	
}
