
// MyFirstDialogDlg.cpp : ���� ����
//
#include "stdafx.h"
#include "MyFirstDialog.h"
#include "MyFirstDialogDlg.h"
#include "afxdialogex.h"

#include <fstream>

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// ���� ���α׷� ������ ���Ǵ� CAboutDlg ��ȭ �����Դϴ�.

class CAboutDlg : public CDialogEx
{
public:
	CAboutDlg();

// ��ȭ ���� �������Դϴ�.
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV �����Դϴ�.

// �����Դϴ�.
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


// CMyFirstDialogDlg ��ȭ ����




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


// CMyFirstDialogDlg �޽��� ó����

BOOL CMyFirstDialogDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// �ý��� �޴��� "����..." �޴� �׸��� �߰��մϴ�.

	// IDM_ABOUTBOX�� �ý��� ��� ������ �־�� �մϴ�.
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

	// �� ��ȭ ������ �������� �����մϴ�. ���� ���α׷��� �� â�� ��ȭ ���ڰ� �ƴ� ��쿡��
	//  �����ӿ�ũ�� �� �۾��� �ڵ����� �����մϴ�.
	SetIcon(m_hIcon, TRUE);			// ū �������� �����մϴ�.
	SetIcon(m_hIcon, FALSE);		// ���� �������� �����մϴ�.

	// TODO: ���⿡ �߰� �ʱ�ȭ �۾��� �߰��մϴ�.

	GetDlgItem(IDC_EDIT_CONTENT)->SetFocus();

	return FALSE;  // ��Ŀ���� ��Ʈ�ѿ� �������� ������ TRUE�� ��ȯ�մϴ�.
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

// ��ȭ ���ڿ� �ּ�ȭ ���߸� �߰��� ��� �������� �׸�����
//  �Ʒ� �ڵ尡 �ʿ��մϴ�. ����/�� ���� ����ϴ� MFC ���� ���α׷��� ��쿡��
//  �����ӿ�ũ���� �� �۾��� �ڵ����� �����մϴ�.

void CMyFirstDialogDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // �׸��⸦ ���� ����̽� ���ؽ�Ʈ�Դϴ�.

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// Ŭ���̾�Ʈ �簢������ �������� ����� ����ϴ�.
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// �������� �׸��ϴ�.
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

// ����ڰ� �ּ�ȭ�� â�� ���� ���ȿ� Ŀ���� ǥ�õǵ��� �ý��ۿ���
//  �� �Լ��� ȣ���մϴ�.
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
	    // �����ڵ� �ؽ�Ʈ ���̸�ŭ ����Ѵ�
	WriteFile(hFile, strBuf, strBuf.GetLength() * 2, &dwWrite, NULL);
    CloseHandle(hFile); // ���� �ʿ������ �ڵ��� �ݴ´�
	*/

	// MFC
	CFile file;
	file.Open(_T("D:\\mfc.txt"), CFile::modeCreate|CFile::modeNoTruncate|CFile::modeWrite);
	file.Write(strBuf, strBuf.GetLength() * sizeof(TCHAR)); // ���Ͽ� ���
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
		AfxMessageBox(_T("���� �Է����ּ���"));
		return;
	}

	m_listbox_content.AddString(strBuf);

	int index = m_listbox_content.GetCount() - 1;

	m_listbox_content.SetCurSel(index);
	// AfxMessageBox(strBuf+"��(��) �߰��Ǿ����ϴ�");
}


void CMyFirstDialogDlg::OnBnClickedButtonRemove()
{
	// TODO: Add your control notification handler code here
	int index = m_listbox_content.GetCurSel();
	int count = m_listbox_content.GetCount();

	
	if(count == 0)
	{
		//AfxMessageBox(_T("���̻� ������ �׸��� �����ϴ�."));
		return;
	}
	/*
	if(index < 0)
	{
		AfxMessageBox(_T("����Ʈ�� �������ּ���"));
		return;
	}
	*/
	
	
	CString strBuf = _T("");
	m_listbox_content.GetText(index, strBuf);

	int nResult = AfxMessageBox(strBuf + _T("��(��) �����Ͻðڽ��ϱ� ?"), MB_YESNO);

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
